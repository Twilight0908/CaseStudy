package management.manager;

import ioFile.ComicsIOFile;
import management.iManagement.DocumentManagement;
import model.Comics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComicsManagement implements DocumentManagement<Comics> {
    private List<Comics> comicsList = null;
    private ComicsIOFile comicsIOFile = new ComicsIOFile();

    public ComicsManagement() {
        try {
            this.comicsList = this.comicsIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Comics comics) {
        try {
            this.comicsList.add(comics);
            this.comicsIOFile.writerFile(comicsList);
            System.out.println("Thêm Thành Công !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Comics comics) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.comicsList.set(index, comics);
                this.comicsIOFile.writerFile(comicsList);
                System.out.println("Sửa Thành Công !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Không Có Id Muốn Sửa !!!");
        }
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.comicsList.remove(index);
                this.comicsIOFile.writerFile(comicsList);
                System.out.println("Xóa Thành Công !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Không Có Id Muốn Xóa !!!");
        }
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < this.comicsList.size(); i++) {
            if (id.equals(this.comicsList.get(i).getDocumentId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Comics> getAll() {
        try {
            return this.comicsIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comics> findByName(String name) {
        List<Comics> list = new ArrayList<>();
        for (Comics comics : comicsList) {
            if (comics.getComicsName().toLowerCase().contains(name.toLowerCase())) {
                list.add(comics);
            }
        }
        return list;
    }
}
