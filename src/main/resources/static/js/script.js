let authorsCounter = 1;

function addAuthorField() {

    if ($(".extra-author-field").length <= 10) {
        appendAuthorField(authorsCounter);
        authorsCounter++;
    }
}

$( document ).ready(function() {
    // let amountOfAuthors = $("#amount-of-authors").val();
    // if (amountOfAuthors > 0) {
    //     let i;
    //     for (i = 1; i < amountOfAuthors; i++) {
    //         appendExistedAuthorField(i);
    //     }
    // }
});


function appendAuthorField(authorId) {
    let authorInput = '<div class="row mt-2"> ' +
        '<div class="col"> ' +
        '<input type="text" class="form-control" name="authors[' + authorId + '].firstName"> ' +
        '</div> ' +
        '<div class="col"> ' +
        '<input type="text" class="form-control"  name="authors[' + authorId + '].lastName"> ' +
        '</div> ' +
        '</div>';

    $("#edit-book_author_fields").append(authorInput);
}

function chooseBookCover() {
    $("#edit-book__picture-upload").click();
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#edit-book_image-cover')
                .attr('src', e.target.result)
        };

        reader.readAsDataURL(input.files[0]);
    }
}
