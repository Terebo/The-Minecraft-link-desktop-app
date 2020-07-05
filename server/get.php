<?php
mysql_connect('www.yourDatabase.here:3306', 'your username', 'your password') or die(mysql_error());
//database name
mysql_select_db("your database name") or die(mysql_error());
$rows = $_GET['rows'];
//table and coloumn name
$query = "SELECT Messages FROM `Messages` LIMIT $rows,1000";
//select all the things in the database
$fetched = mysql_query($query)or die(mysql_error());

//generate a .tsf from the data
$data = '{"messages":[]}';
$data = json_decode($data, true);
if(mysql_num_rows($fetched)>=1){
    while($row = mysql_fetch_array($fetched)) {
        $fetcher = $row['Messages'];
        array_push( $data['messages'], $fetcher);
    }
}

header('Content-type: application/json');
echo json_encode( $data );
?>