//Đầu tiên mở 1 link ở sstruyen ra nhé
//Gọi các hàm xử lý khác để lấy dữ liệu cho db
function getBookDb(doc) {
	//b1: lấy danh sách url truyện
	var listurl = getBookUrls(doc);
	console.log(listurl);
	//b2: lấy thông tin từng truyện trong danh sách vừa lấy được và gọi api gửi dữ liệu lên sever để lưu thông tin các truyện vào db
	//b3: lấy nội dung các chap chuyện vừa lấy được và đẩy  gọi api gửi dữ liệu lên sever để lưu thông tin các truyện vào db
	//tùy cơ ứng biến, t chỉ viết vậy thôi
}

//lấy danh sách url
function getBookUrls(doc) {
	var listUrls = new Array();
	for(let i = 1; i < 5; i ++) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == XMLHttpRequest.DONE) {
				var doc = new DOMParser().parseFromString(xhr.responseText, "text/html");
				var bookList = doc.querySelector('div.book-list').querySelector('tbody').getElementsByTagName('tr');
				for (let i = 0; i < bookList.length ; i++) {
					var url = bookList[i].querySelector('h3.rv-home-a-title').querySelector('a').href;
					//console.log(url);
					listUrls.push(url);
				}
			}
		}
		xhr.open('GET', 'https://sstruyen.com/?lib=all&p=' + i, false);
		xhr.send(null);
	}
	return listUrls;
}

getBookDb(document);