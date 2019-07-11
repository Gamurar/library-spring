var checked = [];

$( document ).ready(function() {
    $('input').iCheck({
        checkboxClass: 'icheckbox_flat-blue',
        radioClass: 'iradio_flat-blue',
        increaseArea: '20%' // optional
    });

    $('input').on('ifChecked', function(event){
        checked.push($(this).val());

        console.log(checked);
    });

    $('input').on('ifUnchecked', function(event){
        let id = $(this).val();

        let index = checked.indexOf(id);
        if (index > -1) {
            checked.splice(index, 1);
        }

        console.log(checked);
    });
});

function deleteBorrowedBooks(btn) {
    let idsStr = "";
    checked.forEach(function(id) {
        idsStr += id + ",";
    });
    console.log($(btn).parent().append("<input type='hidden' name='checkedBorrowedBooksId' value='" + idsStr + "'></input>"));
}