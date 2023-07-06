package model;

public class Books extends Document {
    private String bookName;
    private String authorName;
    private String category;
    private int pageNumber;
    private double bookPrice;

    public Books() {
    }

    public Books(String documentId, String publisherName, int releaseNumber, String bookName, String authorName, String category, int pageNumber, double bookPrice) {
        super(documentId, publisherName, releaseNumber);
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.pageNumber = pageNumber;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Mã Sách: " + super.getDocumentId() + "\n" +
                "Nhà Xuất Bản: " + super.getPublisherName() + "\n" +
                "Tên Sách: " + this.getBookName() + "\n" +
                "Tác Giả: " + this.getAuthorName() + "\n" +
                "Thể Loại: " + this.getCategory() + "\n" +
                "Số Lượng: " + super.getReleaseNumber() + "\n" +
                "Số Trang: " + this.getPageNumber() + "\n" +
                "Giá: " + this.getBookPrice() + "VNĐ";
    }
}
