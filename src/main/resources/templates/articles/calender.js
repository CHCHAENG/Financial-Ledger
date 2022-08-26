 // 달력 생성
 const makeCalendar = (date) => {
    
    // 현재의 년도와 월 받아오기
    const nowYear = new Date(date).getFullYear();
    const nowMonth = new Date(date).getMonth() + 1;

    // 지난달의 마지막 요일
    const prevDay = new Date(nowYear, nowMonth - 1, 1).getDay();

    // 현재 월의 마지막 날 구하기
    const lastDay = new Date(nowYear, nowMonth, 0).getDate();

    // // NEW
    // // 지난 달 마지막 날짜와 요일
    // const prevLast = new Date(nowYear, nowMonth, 0);
    // const PLDate = prevLast.getDate();
    // const PLDay = prevLast.getDay();

    // // 이번 달 마지막 날짜와 요일
    // const thisLast = new Date(nowYear, nowMonth + 1, 0);
    // const TLDate = thisLast.getDate();
    // const TLDay = thisLast.getDay();

    // // 날짜 데이터 저장
    // const prevDates = [];
    // const nextDates = [];

    // if (PLDay !== 6){
    //     for (let i = 0; i < PLDay + 1; i++){
    //         prevDates.unshift(PLDate - i);
    //     }
    // }

    // for (let i = 1; i < 7 - TLDay; i++){
    //     nextDates.push(i);
    // }

    // 남은 박스만큼 다음달 날짜 표시
    let nextDay = (prevDay + lastDay) % 7;
    
    if (nextDay == 0) nextDay = 7;

    let htmlDummy = '';

    // 전달 날짜 표시하기
    for (let i = 0; i < prevDay; i++) {
      htmlDummy += `<div class="noColor"></div>`;
    }

    // prevDates.forEach ((date, i) =>{
    //     prevDates[i] =`<div class="noColor">${date}</div>`;
    // })
    
  
    // 현재 날짜 표시하기
    for (let i = 1; i <= lastDay; i++) {    
      htmlDummy += `<div>${i}</div>`;
    }

    // 다음달 날짜 표시하기
    for (let i = nextDay; i < 7; i++) {
      htmlDummy += `<div class="noColor"></div>`;
    }

    // 날짜 박스 표시하기
    document.querySelector(`.dateBoard`).innerHTML = htmlDummy;

    // 현재 날짜 정보 표시하기
    document.querySelector(`.dateTitle`).innerText = `${nowYear}년 ${nowMonth}월`;
  }
  
window.onload = () => {
  const date = new Date();
 
  makeCalendar(date);
  
  // 이전달 이동
  document.querySelector(`.prevDay`).onclick = () => {
    makeCalendar(new Date(date.setMonth(date.getMonth() - 1)));
  }
  
  // 다음달 이동
  document.querySelector(`.nextDay`).onclick = () => {
    makeCalendar(new Date(date.setMonth(date.getMonth() + 1)));
  }
};