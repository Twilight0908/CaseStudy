package model;

public class Comics extends Document {
    private String comicsName;
    private String authorName;
    private String category;
    private int pageNumber;
    private double comicsPrice;

    public Comics() {
    }

    public Comics(String documentId, String publisherName, int releaseNumber, String comicsName, String authorName, String category, int pageNumber, double comicsPrice) {
        super(documentId, publisherName, releaseNumber);
        this.comicsName = comicsName;
        this.authorName = authorName;
        this.category = category;
        this.pageNumber = pageNumber;
        this.comicsPrice = comicsPrice;
    }

    public String getComicsName() {
        return comicsName;
    }

    public void setComicsName(String comicsName) {
        this.comicsName = comicsName;
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

    public double getComicsPrice() {
        return comicsPrice;
    }

    public void setComicsPrice(double comicsPrice) {
        this.comicsPrice = comicsPrice;
    }

    @Override
    public String toString() {
        return "Mã Truyện: " + super.getDocumentId() + "\n" +
                "Nhà Xuất Bản: " + super.getPublisherName() + "\n" +
                "Tên Truyện: " + this.getComicsName() + "\n" +
                "Tác Giả: " + this.getAuthorName() + "\n" +
                "Thể Loại: " + this.getCategory() + "\n" +
                "Số Lượng: " + super.getReleaseNumber() + "\n" +
                "Số Trang: " + this.getPageNumber() + "\n" +
                "Giá: " + this.getComicsPrice() + "VNĐ";
    }
}
