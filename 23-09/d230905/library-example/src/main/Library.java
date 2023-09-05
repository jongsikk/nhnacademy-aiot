package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> books;
    private int maxNum;

    public Library(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수로는 도서관을 생성할 수 없습니다.");
        }
        books = new ArrayList<>(num);
        maxNum = num;
    }

    public void add(String book) {
        if (getTotalBookCount() >= maxNum) {
            throw new IllegalArgumentException("도서관 최대 용량을 초과해 책을 추가할 수 없습니다.");
        }
        if (find(book)) {
            throw new IllegalArgumentException("도서관에 같은 이름의 책이 존재합니다.");
        }
        books.add(book);
    }

    public boolean find(String book) {
        return books.contains(book);
    }

    public void delete(String book) {
        if (find(book)) {
            books.remove(book);
        } else {
            throw new IllegalArgumentException("도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
        }
    }

    public int getTotalBookCount() {
        return books.size();
    }

}
