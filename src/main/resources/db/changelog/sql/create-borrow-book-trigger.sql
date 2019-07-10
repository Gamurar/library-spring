CREATE TRIGGER before_borrowed_book_insert
    BEFORE INSERT ON borrowed_book
    FOR EACH ROW
BEGIN
    UPDATE book
    SET copies = copies-1
    WHERE book.isbn = new.book_isbn;
END;
