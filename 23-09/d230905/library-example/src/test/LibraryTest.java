package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Library;

class LibraryTest {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";

    @Test
    void negativeLibrary_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Library(-1));
        assertEquals(exception.getMessage(), NEGATIVE_LIBRARY_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = { "해리포터", "어린왕자", "샬롯의 거미줄" })
    void addBook(String bookName) {
        Library library = new Library(5);
        library.add(bookName);
    }

    @Test
    void addMoreThanMax() {
        Library oneLibrary = new Library(1);

        oneLibrary.add("자바의 정석");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> oneLibrary.add("모두의 리눅스"));
        assertEquals(exception.getMessage(), ADD_MORE_THAN_MAX_MESSAGE);
    }

    @Test
    void duplicateBook() {
        Library library = new Library(5);
        library.add("백설공주");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.add("백설공주"));
        assertEquals(exception.getMessage(), ADD_DUPLICATE_BOOK_MESSAGE);
    }

    @Test
    void findBook() {
        Library library = new Library(5);

        library.add("어린왕자");
        assert library.find("어린왕자");
        assert !library.find("엄지공주");
    }

    @Test
    void deleteBook() {
        Library library = new Library(5);
        library.add("백설공주");
        library.delete("백설공주");
    }

    @Test
    void deleteNotExistBook() {
        Library library = new Library(5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.delete("흥부와 놀부"));
        assertEquals(exception.getMessage(), DELETE_NOT_EXIST_BOOK_MESSAGE);
    }
}
