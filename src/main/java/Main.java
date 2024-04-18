import model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
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
        secretCharacterDataLanguageImport(workbook);
    }

    private static void secretCharacterDataLanguageImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(1);
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
                    for (var cell : row) {
                        enSecretCharacterDataLanguage.setLanguageCode(languageEn);
                        thSecretCharacterDataLanguage.setLanguageCode(languageTh);
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

                        if (cell.getColumnIndex() == 5) {
                            enSecretCharacterDataLanguage.setPersonality("EN-" + enSecretCharacterDataLanguage.getCharacterName() + "-" + cell.getStringCellValue());
                            thSecretCharacterDataLanguage.setPersonality("TH-" + thSecretCharacterDataLanguage.getCharacterName() + "-" + cell.getStringCellValue());
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

    private static void luckyNumberDabImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(5);
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
                    for (var cell : row) {
                        enLuckyNumberDabDataLanguage.setLanguageCode(languageEn);
                        thLuckyNumberDabDataLanguage.setLanguageCode(languageTh);

                        if (cell.getColumnIndex() == 0) {
                            enLuckyNumberDabDataLanguage.setSumDateMonth((short) cell.getNumericCellValue());
                            thLuckyNumberDabDataLanguage.setSumDateMonth((short) cell.getNumericCellValue());
                        }

                        if (cell.getColumnIndex() == 1) {
                            enLuckyNumberDabDataLanguage.setOverall("EN-" + enLuckyNumberDabDataLanguage.getSumDateMonth() + "-" + cell.getStringCellValue());
                            thLuckyNumberDabDataLanguage.setOverall("TH-" + enLuckyNumberDabDataLanguage.getSumDateMonth() + "-" + cell.getStringCellValue());
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

    private static void luckyNumberDowImport(XSSFWorkbook workbook) {
        Sheet sheet = workbook.getSheetAt(5);
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                for (var row : sheet) {
                    if (row.getRowNum() <= 4 || row.getRowNum() >= 12) {
                        continue;
                    }

                    for (var cell : row) {
                        LuckyNumberDowDatum luckyNumberDowDatum = new LuckyNumberDowDatum();
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
                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 5) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("โชคลาภและการเงิน");
                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 6) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("ความรัก");
                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 7) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("แคล้วคลาด");
                            session.persist(luckyNumberDowDatum);
                        }

                        if (cell.getColumnIndex() == 8) {
                            try {
                                luckyNumberDowDatum.setLuckyNumber(cell.getStringCellValue());
                            } catch (IllegalStateException ex) {
                                luckyNumberDowDatum.setLuckyNumber(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            luckyNumberDowDatum.setTopicType("comboset");
                            session.persist(luckyNumberDowDatum);
                        }
                        if (!transaction.isActive()) {
                            transaction.commit();
                        }
                    }

                }
            }
        }
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
                        LuckyWallpaperDataLanguage enLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();
                        LuckyWallpaperDataLanguage thLuckyWallpaperDataLanguage = new LuckyWallpaperDataLanguage();


                        if (cell.getColumnIndex() == 3) {
                            enLuckyWallpaperDataLanguage.setTopicType("work");
                            thLuckyWallpaperDataLanguage.setTopicType("work");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN work " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH work " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 4) {
                            enLuckyWallpaperDataLanguage.setTopicType("money");
                            thLuckyWallpaperDataLanguage.setTopicType("money");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN money " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH money " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 5) {
                            enLuckyWallpaperDataLanguage.setTopicType("love");
                            thLuckyWallpaperDataLanguage.setTopicType("love");
                            enLuckyWallpaperDataLanguage.setTopicResult("EN love " + cell.getStringCellValue());
                            thLuckyWallpaperDataLanguage.setTopicResult("TH love " + cell.getStringCellValue());
                        }

                        if (cell.getColumnIndex() == 6) {
                            enLuckyWallpaperDataLanguage.setTopicType("health");
                            thLuckyWallpaperDataLanguage.setTopicType("health");
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
