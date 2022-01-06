<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="style.css"/>
</head>
<body>

<form method="post" action="tool.php" class="form">
    <h2>Tool crawl data SStruyen</h2>

    Link(Nhập link SStruyen vào đây nhé) : <input type="text" name="link" value=""/>

    <input type="submit" name="crawl" value="CRAWL DATA"/>
    <?php require 'test.php'; ?>
</form>

</body>
</html>
