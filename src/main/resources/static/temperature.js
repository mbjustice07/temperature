

function getList(){
    $.ajax({
        url: "/list",
        success: function (result){
            var table = '';
            $("tr:has(td)").remove();
            $.each(result, function(i, degree) {
                table += '<tr><td>' + degree.temperatureUnit + '</td><td>' + degree.temp +'</td><td>' + degree.id +'</td><td>' + degree.createDate + '</td><td>'+ degree.updateDate +'</td></tr>'
            });
            $('#temperatureTable').append(table);
        }
    });
}

function addTemp(temperature){

    urlString = "/addTemp/" + temperature;
    $.ajax({
        url: urlString,
        type: 'post',
        success: function(result){
            getList();
        }
    });
}

function updateTemp(id, temperature){
    urlString = "/updateTemp/"+ id + "/" + temperature;
    console.log(urlString);
    $.ajax({
        url: urlString,
        type: 'put',
        success: function(result){
            getList();
                }
    });
}

function deleteTemp(id){
    urlString = "/removeTemp/"+ id ;
    console.log(urlString);
    $.ajax({
        url: urlString,
        type: 'delete',
        success: function(result){
            getList();
        }
    });
}

$(document).ready(function(){
    getList();
});
