var mysql = require('mysql');
var $ = require('jquery');
var _ = require('underscore')

//sets up the connection, make sure this is the same as in your php on your server
function reconnect() {
    const input = document.getElementById("container");
    const b = $.ajax({
		url: 'https://www.yourPath.here/get.php?rows=' + window.rows,
		type: "GET",
		dataType: "json",
		success: function (response) {
            responsea = response
            responsea.messages.forEach(element => {
                var thing = document.createElement("div");
                thing.innerHTML = element;
                input.appendChild(thing);
            });
            window.rows = input.childElementCount;
        }})
    const c = $.ajax({
		url: 'https://www.yourPath.here/get.php?rows=0',
		type: "GET",
		dataType: "json",
		success: function (response) {
            responsea = response
            if (responsea.messages[0] !== _.unescape(input.firstElementChild.innerHTML)) {
                window.rows = 0;
                console.log(window.rows);
                input.innerHTML = "";
                reconnect();
            }
        }})
}