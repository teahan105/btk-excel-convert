import model.FaceReadingDataLanguage;
import model.FaceReadingDatum;
import model.Language;
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
        faceReadingImport(workbook);

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
