package ioFile;

import model.Books;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookIOFile implements IOFile<Books> {
    private File file = new File("BookStore/data/books.csv");

    @Override
    public void writerFile(List<Books> books) throws IOException {
        String data = "";
        for (Books books1 : books) {
            data += books1.getDocumentId() + "," +
                    books1.getPublisherName() + "," +
                    books1.getReleaseNumber() + "," +
                    books1.getBookName() + "," +
                    books1.getAuthorName() + "," +
                    books1.getCategory() + "," +
                    books1.getPageNumber() + "," +
                    books1.getBookPrice() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    @Override
    public List<Books> readerFile() throws IOException {
        List<Books> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Books(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7])));
        }
        bufferedReader.close();
        return list;
    }
}
