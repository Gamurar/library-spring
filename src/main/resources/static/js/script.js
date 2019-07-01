function addAuthorField() {

    if ($(".extra-author-field").length <= 10) {
        let authorInput = '<input type="text" class="form-control mt-3 extra-author-field" required="">';

        $("#edit-book_author_fields").append(authorInput);
    }
}