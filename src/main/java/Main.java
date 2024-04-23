import model.*;
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
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("/Users/teahan/IdeaProjects/btk-excel-convert/src/main/resources/btk-file.xlsx");
        FileInputStream fileEn = new FileInputStream("/Users/teahan/IdeaProjects/btk-excel-convert/src/main/resources/btk-file-en.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFWorkbook workbookEn = new XSSFWorkbook(fileEn);
        secretCharacterDataLanguageImport(workbook, workbookEn);
    }

    private static void secretCharacterDataLanguageImport(XSSFWorkbook workbook, XSSFWorkbook workbookEn) {
        Sheet sheet = workbook.getSheetAt(1);
        Sheet sheetEn = workbookEn.getSheetAt(1);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                Language languageEn = session.get(Language.class, 1);
                Language languageTh = session.get(Language.class, 2);
                for (var row : sheet) {
                    if (row.getRowNum() <= 1 || row.getRowNum() >= 32) {
                        continue;
                    }
                    SecretCharacterDataLanguage enSecretCharacterDataLanguage = new SecretCharacterDataLanguage();
                    SecretCharacterDataLanguage thSecretCharacterDataLanguage = new SecretCharacterDataLanguage();
                    var rowEn = sheetEn.getRow(row.getRowNum());
                    for (var cell : row) {
                        enSecretCharacterDataLanguage.setLanguageCode(languageEn);
                        thSecretCharacterDataLanguage.setLanguageCode(languageTh);
                        var cellEn = rowEn.getCell(cell.getColumnIndex());
                        if (cell.getColumnIndex() == 0) {
                            enSecretCharacterDataLanguage.setTotalNumber((int) cell.getNumericCellValue());
                            thSecretCharacterDataLanguage.setTotalNumber((int) cell.getNumericCellValue());
                        }

                        if (cell.getColumnIndex() == 2) {
                            enSecretCharacterDataLanguage.setCharacterName(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 3) {
                            thSecretCharacterDataLanguage.setCharacterName(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 7) {
                            enSecretCharacterDataLanguage.setPersonality(cellEn.getStringCellValue());
                            thSecretCharacterDataLanguage.setPersonality(cell.getStringCellValue());
                        }
                    }
                    session.persist(enSecretCharacterDataLanguage);
                    session.persist(thSecretCharacterDataLanguage);
                    if (!transaction.isActive()) {
                        transaction.commit();
                    }
                }
            }
        }
    }

    private static void secretCharacterMappingImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(2);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                for (var row : sheet) {
                    if (row.getRowNum() <= 3 || row.getRowNum() >= 34) {
                        continue;
                    }
                    SecretCharacterLogicMapping secretCharacterLogicMapping = new SecretCharacterLogicMapping();
                    for (var cell : row) {
                        if (cell.getColumnIndex() == 0) {
                            secretCharacterLogicMapping.setCharacterMatch((short) cell.getNumericCellValue());
                        }

                        if (cell.getColumnIndex() == 1) {
                            secretCharacterLogicMapping.setTotalNumber((short) cell.getNumericCellValue());
                        }
                    }
                    session.save(secretCharacterLogicMapping);
                    if (!transaction.isActive()) {
                        transaction.commit();
                    }
                }
            }
        }
    }

    private static void luckyNumberDabImport(XSSFWorkbook workbook, XSSFWorkbook workbookEn) {
        Sheet sheet = workbook.getSheetAt(5);
        Sheet sheetEn = workbookEn.getSheetAt(5);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                Language languageEn = session.get(Language.class, 1);
                Language languageTh = session.get(Language.class, 2);
                for (var row : sheet) {
                    if (row.getRowNum() <= 14 || row.getRowNum() >= 113) {
                        continue;
                    }
                    LuckyNumberDabDataLanguage enLuckyNumberDabDataLanguage = new LuckyNumberDabDataLanguage();
                    LuckyNumberDabDataLanguage thLuckyNumberDabDataLanguage = new LuckyNumberDabDataLanguage();
                    var rowEn = sheetEn.getRow(row.getRowNum());
                    for (var cell : row) {
                        enLuckyNumberDabDataLanguage.setLanguageCode(languageEn);
                        thLuckyNumberDabDataLanguage.setLanguageCode(languageTh);
                        var cellEn = rowEn.getCell(cell.getColumnIndex());

                        if (cell.getColumnIndex() == 0) {
                            enLuckyNumberDabDataLanguage.setSumDateMonth((short) cell.getNumericCellValue());
                            thLuckyNumberDabDataLanguage.setSumDateMonth((short) cell.getNumericCellValue());
                        }

                        if (cell.getColumnIndex() == 1) {
                            enLuckyNumberDabDataLanguage.setOverall(cellEn.getStringCellValue());
                            thLuckyNumberDabDataLanguage.setOverall(cell.getStringCellValue());
                        }
                    }
                    session.persist(enLuckyNumberDabDataLanguage);
                    session.persist(thLuckyNumberDabDataLanguage);
                    if (!transaction.isActive()) {
                        transaction.commit();
                    }
                }
            }
        }
    }

    private static void luckyNumberDowImport(XSSFWorkbook workbook, XSSFWorkbook workbookEn) {
        Sheet sheet = workbook.getSheetAt(5);
        Sheet sheetEn = workbookEn.getSheetAt(5);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                Language languageEn = session.get(Language.class, 1);
                Language languageTh = session.get(Language.class, 2);
                for (var row : sheet) {
                    if (row.getRowNum() <= 4 || row.getRowNum() >= 12) {
                        continue;
                    }
                    var rowEn = sheetEn.getRow(row.getRowNum());
                    String overall = row.getCell(2).getStringCellValue();
                    String overallEn = rowEn.getCell(2).getStringCellValue();
                    for (var cell : row) {
//                        var cellEn = rowEn.getCell(cell.getColumnIndex());
                        var luckyNumberDowDatum = new LuckyNumberDowDataLanguage();
                        luckyNumberDowDatum.setLanguageCode(languageTh);
                        luckyNumberDowDatum.setOverall(overall);
                        var luckyNumberDowDatumEn = new LuckyNumberDowDataLanguage();
                        luckyNumberDowDatumEn.setLanguageCode(languageEn);
                        luckyNumberDowDatumEn.setOverall(overallEn);

                        if (cell.getRowIndex() == 5) {
                            luckyNumberDowDatum.setDayOfWeek((short) 0);
                        }

                        if (cell.getRowIndex() == 6) {
                            luckyNumberDowDatum.setDayOfWeek((short) 1);
                        }

                        if (cell.getRowIndex() == 7) {
                            luckyNumberDowDatum.setDayOfWeek((short) 2);
                        }

                        if (cell.getRowIndex() == 8) {
                            luckyNumberDowDatum.setDayOfWeek((short) 3);
                        }

                        if (cell.getRowIndex() == 9) {
                            luckyNumberDowDatum.setDayOfWeek((short) 4);
                        }

                        if (cell.getRowIndex() == 10) {
                            luckyNumberDowDatum.setDayOfWeek((short) 5);
                        }

                        if (cell.getRowIndex() == 11) {
                            luckyNumberDowDatum.setDayOfWeek((short) 6);
                        }
                        if (List.of(5,6,7,8,9,10,11).contains(cell.getRowIndex())) {
                            luckyNumberDowDatumEn.setDayOfWeek(luckyNumberDowDatum.getDayOfWeek());
                        }


                        if (cell.getColumnIndex() == 3) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("work");
                        }

                        if (cell.getColumnIndex() == 4) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("kindness");
//                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 5) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("โชคลาภและการเงิน");
//                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 6) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("ความรัก");
//                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 7) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("แคล้วคลาด");
//                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 8) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("comboset");
//                            session.persist(luckyNumberDowDatum);
                        }

                        if (List.of(3,4,5,6,7,8).contains(cell.getColumnIndex())) {
                            luckyNumberDowDatumEn.setLuckyNumber(luckyNumberDowDatum.getLuckyNumber());
                            luckyNumberDowDatumEn.setTopicType(luckyNumberDowDatum.getTopicType());

                            session.persist(luckyNumberDowDatum);
                            session.persist(luckyNumberDowDatumEn);
                        }

                        if (!transaction.isActive()) {
                            transaction.commit();
                        }
                    }

                }
            }
        }
    }

    private static void luckyWallPaperImport(XSSFWorkbook workbook, XSSFWorkbook workbookEn) {
        Sheet sheet = workbook.getSheetAt(4);
        Sheet sheetEn = workbookEn.getSheetAt(4);
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

                    var rowEn = sheetEn.getRow(row.getRowNum());
                    String wallpaperName = row.getCell(1).getStringCellValue();
                    String luckyMeaning = row.getCell(2).getStringCellValue();
                    String wallpaperNameEn = rowEn.getCell(1).getStringCellValue();
                    String luckyMeaningEn = rowEn.getCell(2).getStringCellValue();
                    for (var cell : row) {
                        LuckyWallpaperDataLanguage enLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();
                        LuckyWallpaperDataLanguage thLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();
                        var cellEn = rowEn.getCell(cell.getColumnIndex());

                        if (cell.getColumnIndex() == 3) {
                            enLuckyWallpaperDataLanguage.setTopicType("work");
                            thLuckyWallpaperDataLanguage.setTopicType("work");
                            enLuckyWallpaperDataLanguage.setTopicResult(cellEn.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 4) {
                            enLuckyWallpaperDataLanguage.setTopicType("money");
                            thLuckyWallpaperDataLanguage.setTopicType("money");
                            enLuckyWallpaperDataLanguage.setTopicResult(cellEn.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 5) {
                            enLuckyWallpaperDataLanguage.setTopicType("love");
                            thLuckyWallpaperDataLanguage.setTopicType("love");
                            enLuckyWallpaperDataLanguage.setTopicResult(cellEn.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 6) {
                            enLuckyWallpaperDataLanguage.setTopicType("health");
                            thLuckyWallpaperDataLanguage.setTopicType("health");
                            enLuckyWallpaperDataLanguage.setTopicResult(cellEn.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult(cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 3 || cell.getColumnIndex() == 4
                                || cell.getColumnIndex() == 5 || cell.getColumnIndex() == 6) {
                            enLuckyWallpaperDataLanguage.setLanguageCode(languageEn);
                            enLuckyWallpaperDataLanguage.setName(wallpaperNameEn);
                            enLuckyWallpaperDataLanguage.setLuckyMeaning(luckyMeaningEn);

                            thLuckyWallpaperDataLanguage.setLanguageCode(languageTh);
                            thLuckyWallpaperDataLanguage.setName(wallpaperName);
                            thLuckyWallpaperDataLanguage.setLuckyMeaning(luckyMeaning);

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

    private static void faceReadingImport(XSSFWorkbook workbook, XSSFWorkbook workbookEn) {
        Sheet sheet = workbook.getSheetAt(3);
        Sheet sheetEn = workbookEn.getSheetAt(3);

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
                    var rowEn = sheetEn.getRow(row.getRowNum());
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
                                var cellEn = rowEn.getCell(cell.getColumnIndex());

                                enFaceReadingDataLanguage.setTopicResult(cell.getStringCellValue());
                                thFaceReadingDataLanguage.setTopicResult(cellEn.getStringCellValue());
                                enFaceReadingDataLanguage.setLanguageCode(languageEn);
                                thFaceReadingDataLanguage.setLanguageCode(languageTh);
                                enFaceReadingDataLanguage.setFaceReadingData(faceReadingData);
                                thFaceReadingDataLanguage.setFaceReadingData(faceReadingData);
                                session.persist(enFaceReadingDataLanguage);
                                session.persist(thFaceReadingDataLanguage);
                            }
                        }
                        if (!transaction.isActive()) {
                            transaction.commit();
                        }
                    } catch (Exception ex) {
                        continue;
                    }
                }

            }
        }
    }
}
