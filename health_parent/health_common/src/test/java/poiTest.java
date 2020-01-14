public class poiTest {
//    @Test
//    public void test1() throws Exception{
//        XSSFWorkbook gongzb=new XSSFWorkbook(new FileInputStream(new File("C:\\tmp\\poi.xlsx")));
//        XSSFSheet sheet1=gongzb.getSheetAt(0);
//        for (Row row : sheet1) {
//            for (Cell cell : row) {
//                System.out.println(cell.getStringCellValue());
//            }
//        }
//        gongzb.close();
//    }
//    @Test
//    public void test2() throws Exception{
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("ssd");
//        XSSFRow row0 = sheet.createRow(0);
//        row0.createCell(0).setCellValue("cell0");
//        row0.createCell(5).setCellValue("cell5");
//        XSSFRow row3 = sheet.createRow(3);
//        row3.createCell(2).setCellValue("cell2");
//        row3.createCell(6).setCellValue("cell6");
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\tmp\\a.xlsx"));
//        workbook.write(fileOutputStream);
//        fileOutputStream.flush();
//        fileOutputStream.close();
//        workbook.close();
//    }
}
