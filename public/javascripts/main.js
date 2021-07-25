$(document).ready(function (){
    $("#portable").click(function (){
        $(".mask").css('display', "inline");
        $(this).css("display", "none")
        $("#portable2").css({"display": "inline", "text-align": "right"})
    })
    $("#portable2").click(function (){
        $(".mask").css('display', "none");
        $("#portable").css("display", "inline")
        $(this).css({"display": "none"})
    })

    $(".accordion").click(function (){
        if ($(this).children(".ndambe").attr("class")=="ndambe glyphicon glyphicon-plus") {
            $(this).children(".ndambe").removeClass("ndambe glyphicon glyphicon-plus").addClass("ndambe glyphicon glyphicon-minus")
        }
        else{
            $(this).children(".ndambe").removeClass("ndambe glyphicon glyphicon-minus").addClass("ndambe glyphicon glyphicon-plus")
        }//alert($(this).children(".ndambe").attr("class"))
    })

    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.display === "block") {
                panel.style.display = "none";
            } else {
                panel.style.display = "block";
            }
        });
    }

})