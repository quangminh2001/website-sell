/**
 * 
 */

<script type="text/javascript">
    $( document ).ready(function() {
        $("#paging").pagination({
            currentPage: 1,
            items: 10,
            itemsOnPage: 5,
            cssStyle: 'light-theme',
            onPageClick: function(pageNumber, event) {
                $('#page').val(pageNumber);
                $('#btnSearch').trigger('click');
            },
        })
    });
</script>