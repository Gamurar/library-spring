CREATE TRIGGER after_borrowed_book_delete
    AFTER DELETE ON borrowed_book
    FOR EACH ROW
BEGIN
    UPDATE book
    SET copies = copies+1
    WHERE book.isbn = old.book_isbn;
END;
