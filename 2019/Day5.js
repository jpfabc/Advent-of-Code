function normalizeOpcode(opcodeInput){
    if(opcodeInput.length<5){
        while(opcodeInput.length<5){
            opcodeInput = "0" + opcodeInput;
        }
    }
    return opcodeInput;
}

function addNumbers(firstNumber,secondNumber){
    let result = parseInt(firstNumber)+parseInt(secondNumber);
    return result.toString();
}

function multiplyNumbers(firstNumber,secondNumber){
    let result = parseInt(firstNumber)*parseInt(secondNumber);
    return result.toString();
}

function readInput(array, input, positionToStore){
    array[positionToStore] = input;
    return array;
}

function logOutput (array, positionToRead, isImmediate){
    if(isImmediate){
        console.log(positionToRead);
    }else{
        console.log(array[positionToRead]);
    }
}

function opcodeAdd(array, opcode, firstParameter, secondParameter , positionToChange){
    if(opcode.charAt(2) == '0' && opcode.charAt(1) == '0'){
        array[positionToChange] = addNumbers (array[firstParameter], array[secondParameter]);
    } else {
        if (opcode.charAt(2) == '0' && opcode.charAt(1) == '1'){
            array[positionToChange] = addNumbers (array[firstParameter], secondParameter);
        } else if(opcode.charAt(2) == '1' && opcode.charAt(1) == '0'){
                  array[positionToChange] = addNumbers (firstParameter, array[secondParameter]);
            }else{
                array[positionToChange] = addNumbers (firstParameter, secondParameter);
        }
    }
    return array;
}

function opcodeMultiply(array, opcode, firstParameter, secondParameter , positionToChange){
    if(opcode.charAt(2) == '0' && opcode.charAt(1) == '0'){
        array[positionToChange] = multiplyNumbers (array[firstParameter], array[secondParameter]);
    } else {
        if (opcode.charAt(2) == '0' && opcode.charAt(1) == '1'){
            array[positionToChange] = multiplyNumbers (array[firstParameter], secondParameter);
        } else if(opcode.charAt(2) == '1' && opcode.charAt(1) == '0'){
                  array[positionToChange] = multiplyNumbers (firstParameter, array[secondParameter]);
            }else{
                array[positionToChange] = multiplyNumbers (firstParameter, secondParameter);
        }
    }
    return array;
}

function runProgram(input){
    let inputArray = input.split(',');
    let i = 0; 
    while (i < inputArray.length){
        inputArray[i] = normalizeOpcode(inputArray[i]);
        if(inputArray[i].charAt(4) == '1'){
            opcodeAdd(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else if (inputArray[i].charAt(4) == '2'){
            opcodeMultiply(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else if (inputArray[i].charAt(4) == '3'){
            readInput(inputArray, '1', inputArray[i+1]);
            i += 2;
        }else if (inputArray[i].charAt(4) == '4'){
            if(inputArray[i].charAt(2) == '1'){
                logOutput(inputArray, inputArray[i+1], true);
            }else{
                logOutput(inputArray, inputArray[i+1], false);
            }
            i += 2;
        }else {
            break;
        }
    }
}

// ---------------------------------- Part 2 ----------- //

function opcodeJumpTrue (array, opcode, firstParameter, secondParameter, current) {
    if ((opcode.charAt(2) == '0' && array[firstParameter] != '0') || (opcode.charAt(2) == '1' && firstParameter != '0')){
        if (opcode.charAt(1) == '0'){
            return parseInt(array[secondParameter]);
        }else{
            return parseInt(secondParameter);
        }
    }
    return current+3;
}

function opcodeJumpFalse (array, opcode, firstParameter, secondParameter,current) {
    if ((opcode.charAt(2) == '0' && array[firstParameter] == '0') || (opcode.charAt(2) == '1' && firstParameter == '0')){
        if (opcode.charAt(1) == '0'){
            return parseInt(array[secondParameter]);
        }else{
            return parseInt(secondParameter);
        }
    }
    return current+3;
}

function opcodeLessThan (array, opcode, firstParameter, secondParameter, positionToStore){
    if(opcode.charAt(2) == '0' && opcode.charAt(1) == '0'){
        if(array[firstParameter] < array[secondParameter]){
            array[positionToStore] = '1';
            return;
        }
    }else if(opcode.charAt(2) == '0' && opcode.charAt(1) == '1'){
        if(array[firstParameter] < secondParameter){
            array[positionToStore] = '1';
            return;
        }
    } else if(opcode.charAt(2) == '1' && opcode.charAt(1) == '0'){
        if(firstParameter < array[secondParameter]){
            array[positionToStore] = '1';
            return;
        }
    } else{
        if(firstParameter < secondParameter){
            array[positionToStore] = '1';
            return;
        }
    }
    array[positionToStore] = '0';
    return;
}

function opcodeEquals (array, opcode, firstParameter, secondParameter, positionToStore){
    if(opcode.charAt(2) == '0' && opcode.charAt(1) == '0'){
        if(array[firstParameter] == array[secondParameter]){
            array[positionToStore] = '1';
            return;
        }
    }else if(opcode.charAt(2) == '0' && opcode.charAt(1) == '1'){
        if(array[firstParameter] == secondParameter){
            array[positionToStore] = '1';
            return;
        }
    } else if(opcode.charAt(2) == '1' && opcode.charAt(1) == '0'){
        if(firstParameter == array[secondParameter]){
            array[positionToStore] = '1';
            return;
        }
    } else{
        if(firstParameter == secondParameter){
            array[positionToStore] = '1';
            return;
        }
    }
    array[positionToStore] = '0';
    return;
}

function runNewProgram(input){
    let inputArray = input.split(',');
    let i = 0; 
    while (i < inputArray.length){
        inputArray[i] = normalizeOpcode(inputArray[i]);
        if(inputArray[i].charAt(4) == '1'){
            opcodeAdd(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else if (inputArray[i].charAt(4) == '2'){
            opcodeMultiply(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else if (inputArray[i].charAt(4) == '3'){
            readInput(inputArray, '5', inputArray[i+1]);
            i += 2;
        }else if (inputArray[i].charAt(4) == '4'){
            if(inputArray[i].charAt(2) == '1'){
                logOutput(inputArray, inputArray[i+1], true);
            }else{
                logOutput(inputArray, inputArray[i+1], false);
            }
            i += 2;
        }else if(inputArray[i].charAt(4) == '5'){
            i = opcodeJumpTrue(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2],i);
        }else if(inputArray[i].charAt(4) == '6'){
            i = opcodeJumpFalse(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2],i);
        }else if(inputArray[i].charAt(4) == '7'){
            opcodeLessThan(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else if(inputArray[i].charAt(4) == '8'){
            opcodeEquals(inputArray, inputArray[i], inputArray[i+1], inputArray[i+2], inputArray [i+3]);
            i += 4;
        }else{
            break;
        }
    }
}
