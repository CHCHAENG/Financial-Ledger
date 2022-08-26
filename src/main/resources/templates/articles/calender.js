<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="/css/calenderPage.css">
	<link rel="stylesheet" type="text/css" href="/css/calender.css">
	<title>{{user.login_name}}'s Calenderpage</title>
</head>
<body>
	<div class="window-block">
		<div class="side-bar"> <!-- side bar -->
			<div class="img-cost" onclick="location.href='/articles/Costpage';"></div>
			<div class="img-calender" onclick="location.href='/articles/Calenderpage';"></div>
			<div class="img-home" onclick="location.href='/articles/Mainpage';"></div>
			<div class="img-income" onclick="location.href='/articles/Incomepage';"></div>
			<div class="img-profile" onclick="location.href='/articles/Mypage';"></div>
		</div>
		<div class="main-box">
			<!-- 달력 -->
			<div class ="calender">
				<div class='rap'>
					<div class="header">
					   <div class="btn prevDay"></div>
					  <h2 class='dateTitle'></h2>
					  <div class="btn nextDay"></div>
					</div>

					<div class="divasdfa">
						<div class="gridDay dateHead">
						<div>일</div>
						<div>월</div>
						<div>화</div>
						<div>수</div>
						<div>목</div>
						<div>금</div>
						<div>토</div>
						</div>
					</div>

					<div class="grid dateBoard"></div>
				  </div>
				  <!-- 달력 만들기 js 파일 연결-->
				  <script type="text/javascript" src="calender.js"></script>
			</div>

			<div class="detail-bar">
				<pre>울랄라</pre>
			</div>
		</div>
	</div>
</body>
</html>