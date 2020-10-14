function addToPlan(button){
    imdbID=$(button).parent().find("[name='imdb-id']").attr("value");
    $.ajax({
        type:"POST",
        url: "/addToPlan",
        data: {'imdbID':imdbID}
    }).done(function(response){
        if(response=="Ok.")
            $(button).html("Added");
        else
            alert("Error in the backend");
    });
}