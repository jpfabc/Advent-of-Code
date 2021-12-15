let input = [5,1,1,4,1,1,4,1,1,1,1,1,1,1,1,1,1,1,4,2,1,1,1,3,5,1,1,1,5,4,1,1,1,2,2,1,1,1,2,1,1,1,2,5,2,1,2,2,3,1,1,1,1,1,1,1,1,5,1,1,4,1,1,1,5,4,1,1,3,3,2,1,1,1,5,1,1,4,1,1,5,1,1,5,1,2,3,1,5,1,3,2,1,3,1,1,4,1,1,1,1,2,1,2,1,1,2,1,1,1,4,4,1,5,1,1,3,5,1,1,5,1,4,1,1,1,1,1,1,1,1,1,2,2,3,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,5,1,1,1,1,4,1,1,1,1,4,1,1,1,1,3,1,2,1,2,1,3,1,3,4,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,4,1,1,2,2,1,2,4,1,1,3,1,1,1,5,1,3,1,1,1,5,5,1,1,1,1,2,3,4,1,1,1,1,1,1,1,1,1,1,1,1,5,1,4,3,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,3,3,1,2,2,1,4,1,5,1,5,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,4,3,1,1,4];

let zeroDaysFish = 0;
let oneDaysFish = 0;
let twoDaysFish = 0;
let threeDaysFish = 0;
let fourDaysFish = 0;
let fiveDaysFish = 0;
let sixDaysFish = 0;
let sevenDaysFish = 0;
let eightDaysFish = 0;


function prepareArrays(){
    oneDaysFish = input.filter(x => x == 1).length;
    twoDaysFish = input.filter(x => x == 2).length;
    threeDaysFish = input.filter(x => x == 3).length;
    fourDaysFish = input.filter(x => x == 4).length;
    fiveDaysFish = input.filter(x => x == 5).length;
}


function passDay(amountOfDayZeroFishes,amountOfDayOneFishes,amountOfDayTwoFishes,amountOfDayThreeFishes,amountOfDayFourFishes,amountOfDayFiveFishes,amountOfDaySixFishes,amountOfDaySevenFishes,amountOfDayEightFishes){
    zeroDaysFish = amountOfDayOneFishes;
    oneDaysFish = amountOfDayTwoFishes;
    twoDaysFish = amountOfDayThreeFishes;
    threeDaysFish = amountOfDayFourFishes;
    fourDaysFish = amountOfDayFiveFishes;
    fiveDaysFish = amountOfDaySixFishes;
    sixDaysFish = amountOfDaySevenFishes+amountOfDayZeroFishes;
    sevenDaysFish = amountOfDayEightFishes;
    eightDaysFish = amountOfDayZeroFishes;
    return;
}

function getAllFishes(days){
    prepareArrays();
    for(let i = 0; i < days; i++){
        passDay(zeroDaysFish,oneDaysFish,twoDaysFish,threeDaysFish, fourDaysFish,fiveDaysFish,sixDaysFish,sevenDaysFish,eightDaysFish);
    }
    return zeroDaysFish + oneDaysFish + twoDaysFish + threeDaysFish + fourDaysFish + fiveDaysFish + sixDaysFish + sevenDaysFish + eightDaysFish;
}

