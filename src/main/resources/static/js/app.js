
//prevent multiple form submission
$(function() {
    $('form').submit(function(){
        $("button[type='submit']", this)
            .text("Please Wait...")
            .attr('disabled', 'disabled');
        return true;
    });
});
