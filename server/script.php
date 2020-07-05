<?php
//your database info, host, username, password
// TODO remove this info
mysql_connect('www.yourDatabase.here:3306', 'your username', 'your password') or die(mysql_error());
$name = $_GET['player'];
$message = $_GET['message'];
//database name
mysql_select_db("your database name") or die(mysql_error());
//table and coloumn name
$query = "INSERT INTO `Messages` (`Messages`) VALUES ('$name $message');";
mysql_query($query)or die(mysql_error());
?>