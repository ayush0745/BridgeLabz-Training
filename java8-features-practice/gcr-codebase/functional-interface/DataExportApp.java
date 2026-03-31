public class DataExportApp {

    // Interface with default JSON export
    interface DataExporter {

        void exportToCSV();
        void exportToPDF();

        // Newly added feature
        default void exportToJSON() {
            System.out.println("Exporting data to JSON (default implementation)");
        }
    }

    // Existing CSV exporter
    static class CSVExporter implements DataExporter {
        public void exportToCSV() {
            System.out.println("Exporting data to CSV");
        }

        public void exportToPDF() {
            System.out.println("PDF export not supported by CSVExporter");
        }
        // exportToJSON() inherited
    }

    // Existing PDF exporter
    static class PDFExporter implements DataExporter {
        public void exportToCSV() {
            System.out.println("CSV export not supported by PDFExporter");
        }

        public void exportToPDF() {
            System.out.println("Exporting data to PDF");
        }
        // exportToJSON() inherited
    }

    // New exporter with custom JSON logic
    static class AdvancedExporter implements DataExporter {
        public void exportToCSV() {
            System.out.println("Exporting data to CSV");
        }

        public void exportToPDF() {
            System.out.println("Exporting data to PDF");
        }

        @Override
        public void exportToJSON() {
            System.out.println("Exporting data to JSON (custom format)");
        }
    }

    // Main method
    public static void main(String[] args) {

        DataExporter csv = new CSVExporter();
        DataExporter pdf = new PDFExporter();
        DataExporter advanced = new AdvancedExporter();

        csv.exportToCSV();
        csv.exportToJSON();

        pdf.exportToPDF();
        pdf.exportToJSON();

        advanced.exportToJSON();
    }
}
