import model.*;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("/Users/teahan/IdeaProjects/btk-excel-convert/src/main/resources/btk-file.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        luckyWallPaperImport(workbook);

    }

    private static void luckyWallPaperImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(4);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Language languageEn = session.get(Language.class, 1);
                Language languageTh = session.get(Language.class, 2);
                Transaction transaction = session.beginTransaction();
                for (var row : sheet) {
                    if (row.getRowNum() <= 2) {
                        continue;
                    }

                    if (row.getRowNum() == 27) {
                        break;
                    }

                    String wallpaperName = row.getCell(1).getStringCellValue();
                    String luckyMeaning = row.getCell(2).getStringCellValue();

                    for (var cell : row) {
                        var luckyWallpaperDatum = new LuckyWallpaperDatum();
                        LuckyWallpaperDataLanguage enLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();
                        LuckyWallpaperDataLanguage thLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();


                        if (cell.getColumnIndex() == 3) {
                            luckyWallpaperDatum.setTopicType("work");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN work " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH work " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 4) {
                            luckyWallpaperDatum.setTopicType("money");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN money " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH money " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 5) {
                            luckyWallpaperDatum.setTopicType("love");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN love " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH love " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 6) {
                            luckyWallpaperDatum.setTopicType("health");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN health " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH health " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 3 || cell.getColumnIndex() == 4
                                || cell.getColumnIndex() == 5 || cell.getColumnIndex() == 6) {
                            enLuckyWallpaperDataLanguage.setLanguageCode(languageEn);
                            enLuckyWallpaperDataLanguage.setName("EN " + wallpaperName);
                            enLuckyWallpaperDataLanguage.setLuckyMeaning("EN " + luckyMeaning);

                            thLuckyWallpaperDataLanguage.setLanguageCode(languageTh);
                            thLuckyWallpaperDataLanguage.setName("TH " + wallpaperName);
                            thLuckyWallpaperDataLanguage.setLuckyMeaning("TH " + luckyMeaning);

                            session.persist(luckyWallpaperDatum);

                            enLuckyWallpaperDataLanguage.setLuckyWallpaperData(luckyWallpaperDatum);
                            thLuckyWallpaperDataLanguage.setLuckyWallpaperData(luckyWallpaperDatum);
                            session.persist(thLuckyWallpaperDataLanguage);
                            session.persist(enLuckyWallpaperDataLanguage);
                            if (!transaction.isActive()) {
                                transaction.commit();
                            }
                        }
                    }
                }
            }
        }
    }

    private static void faceReadingImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(3);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Language languageEn = session.get(Language.class, 1);
                Language languageTh = session.get(Language.class, 2);
                Transaction transaction = session.beginTransaction();
                for (var row : sheet) {
                    Cell signCodeCell = row.getCell(0);
                    if (Objects.isNull(signCodeCell)) {
                        continue;
                    }
                    String signCode = signCodeCell.getStringCellValue();
                    if (!StringUtils.startsWithAny(signCode, "C", "F", "D")
                            || StringUtils.containsAny(signCode, "Chin", "Forehead", "Date")) {
                        continue;
                    }
                    try {
                        for (var cell : row) {
                            var enFaceReadingDataLanguage = new FaceReadingDataLanguage();
                            var thFaceReadingDataLanguage = new FaceReadingDataLanguage();
                            var faceReadingData = new FaceReadingDatum();
                            faceReadingData.setSignCode(signCode);
                            String topicType = "";

                            if (cell.getColumnIndex() == 3 || cell.getColumnIndex() == 4 || cell.getColumnIndex() == 5) {
                                if (cell.getColumnIndex() == 3) {
                                    topicType = "work";
                                } else if (cell.getColumnIndex() == 4) {
                                    topicType = "money";
                                } else if (cell.getColumnIndex() == 5) {
                                    topicType = "love";
                                }
                                faceReadingData.setTopicType(topicType);
                                session.persist(faceReadingData);

                                enFaceReadingDataLanguage.setTopicResult("EN-" + signCode + "-" + topicType + " " + cell.getStringCellValue());
                                thFaceReadingDataLanguage.setTopicResult("TH-" + signCode + "-" + topicType + " " + cell.getStringCellValue());
                                enFaceReadingDataLanguage.setLanguageCode(languageEn);
                                thFaceReadingDataLanguage.setLanguageCode(languageTh);
                                enFaceReadingDataLanguage.setFaceReadingData(faceReadingData);
                                thFaceReadingDataLanguage.setFaceReadingData(faceReadingData);
                                session.persist(enFaceReadingDataLanguage);
                                session.persist(thFaceReadingDataLanguage);
                                if (!transaction.isActive()) {
                                    transaction.commit();
                                }
                            }
                        }
                    } catch (Exception ex) {
                        continue;
                    }
                }

            }
        }
    }
}
