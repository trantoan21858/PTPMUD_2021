    <?php
    require_once 'simple_html_dom.php';
    $arrContextOptions = array(
        "ssl" => array(
            "verify_peer" => false,
            "verfy_peer_name" => false,
        ),
    );

    $link = $_POST['link'];

    $html = file_get_html("$link");


        $img = $html->find('.sstbcover ',0)->{"data-pagespeed-high-res-src"};
        echo $img;
        if($img==null){
            $content = $html->find('.wrap-single', 0)->find('.rv-chapt-title', 0)->plaintext;
            $content1 = $html->find('.wrap-single', 0)->find('.rv-full-story-title', 0)->plaintext;
            $content2 = $html->find('.wrap-single', 0)->find('.content p');
            if(!empty($content2)){
                foreach ($content2 as $count){
                    $chap = $count->plaintext;

                }
            }
        }
        else {
            $name = $html->find('.book-list', 0)->find('.title', 0)->plaintext;

            $test=$html->find('.content1',0)->find('.info ',0)->find('.rv-sr-a',0)->plaintext;

            $test4=$html->find('.content1 p',1)->plaintext;

            $test3=$html->find('.content1',0)->find('.info ',0)->find('.status',0)->plaintext;
            $test5=$html->find('.content1 p',4)->plaintext;
            $img1 = $html->find('.sstbcover', 1);
        }



//    echo $test1;
//    $author =$test->find('.info ');
//    if(!empty($author)){
//        foreach ($author as $count){
////            $info = $count->find('.rv-sr-a',0)->plaintext;
//            $info=$count->find('.rv-sr-a');
//            if(!empty($info))
//            {
//                foreach ($info as $count){
//            $chap = $count->plaintext;
//            echo $chap. '<br />';
//            }
//            }
////            echo $info .'<br/>';
//
////            return $info;
//        }
//    $author =$test->find('.info ');
//    if(!empty($author)){
//    foreach ($author as $count){
////            $info = $count->find('.rv-sr-a',0)->plaintext;
//        $info=$count->plaintext.',';
//        echo $info.",";


//        return $info;
//        return $info;
//    }
//    }
//    echo $author;

//    $data=$html->find('.book-list');
//    if(!empty($data)){
//        foreach ($data as $count){
//            $chap = $count->find(' .list-chap',0)->plaintext. '<br />';
//            echo $chap. '<br />';
//        }
//    }
    //}
//    echo $data . "<++++++++++++++++++++++++++++++++++++++++++++++++++ />\n";
    //$link2=$_POST['content'];
    //$html2=file_get_html("$link2");

            if($content==null){
                $fp = fopen('C:\\xampp\htdocs\PTUD2021\Data.csv', 'a');//mở file ở chế độ write-only
                $no_rows = count(file('C:\\xampp\htdocs\PTUD2021\Data.csv'));

                if ($no_rows > 1) {
                    $no_rows = ($no_rows - 1) + 1;

                }
                $form_data = array(


                    'img' => $img,
                    'name' => $name,
                    'author'=>$test,
                    'category'=>$test4,
                    'isfull'=>$test3,
                    'intro'=>$test5,


                );
                fputcsv($fp, $form_data);
            }

            else{
                $fp = fopen('C:\\xampp\htdocs\PTUD2021\ContentChapter2.csv', 'a');//mở file ở chế độ write-only
                $no_rows = count(file('C:\\xampp\htdocs\PTUD2021\ContentChapter2.csv'));

                if ($no_rows > 1) {
                    $no_rows = ($no_rows - 1) + 1;
                }
                $chapter = array(
                    'name'=>$content1,
                    'chaptername'=>$content,
                    'chapter_content'=>$chap,
                );
                fputcsv($fp, $chapter);
            }





    echo "Save data Success!";

    
    ?>
