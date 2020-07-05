<?php
//your database info, host, username, password
mysql_connect('www.yourDatabase.here:3306', 'your username', 'your password') or die(mysql_error());
//database name
mysql_select_db("your database name") or die(mysql_error());
//table and coloumn name
$query = "DELETE FROM Messages";
mysql_query($query)or die(mysql_error());
?>