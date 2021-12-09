
function addNumbers(a,b){
    return a+b;
}

function multiplyNumbers(a,b){
    return a*b;
}

function replaceDefaultNumbers(arr){
    arr[1] = 12;
    arr[2] = 2;
    return arr;
}

function replacePositionNumber(arr,positionToChange, newNumber){
    arr[positionToChange] = newNumber;
    return arr;
}

function runProgram(arr){
    arr= arr.map(x=>(parseInt(x)));
    replaceDefaultNumbers(arr);
    for(let i = 0; i<arr.length; i+=4){
        if(arr[i] == 1){
            replacePositionNumber(arr,arr[i+3],addNumbers(arr[arr[i+1]],arr[arr[i+2]]));
            continue;
        }
        if(arr[i] == 2){
            replacePositionNumber(arr,arr[i+3],multiplyNumbers(arr[arr[i+1]],arr[arr[i+2]]));
            continue;
        }
        if(arr[i] == 99){
            break;
        }
    }
    return arr[0];
}

// --------------------------------------------------------------------------
const finalValue=19690720;

function tryInputs(arr){
    for(let noun = 0; noun < 99; noun++){
        for(let verb = 0; verb < 99; verb++){
            tempArr= arr.map(x=>(parseInt(x)));
            tempArr[1] = noun;
            tempArr[2] = verb;
            for(let i = 0; i<tempArr.length; i+=4){
                if(tempArr[i] == 1){
                    replacePositionNumber(tempArr,tempArr[i+3],addNumbers(tempArr[tempArr[i+1]],tempArr[tempArr[i+2]]));
                    continue;
                }
                if(tempArr[i] == 2){
                    replacePositionNumber(tempArr,tempArr[i+3],multiplyNumbers(tempArr[tempArr[i+1]],tempArr[tempArr[i+2]]));
                    continue;
                }
                if(tempArr[i] == 99){
                    break;
                }
            }
            if(tempArr[0] == finalValue){
                return 100*noun + verb;
            }
        }
    }
}
