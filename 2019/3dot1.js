let matrix =[];
function getDirection(wirePath){
    let pattern = /[^\d]+/g;
    return parseInt(wirePath.replace(pattern,""));
}

function startMatrix (){
    matrix = [];
    for(let i = 0 ; i < 40000; i++){
        matrix.push(new Array(40000));
    }
    return matrix;
}

function setWires(input){
    for(let i = 0 ; i < input.length; i++){
        setSingleWire(input[i].split(','),i+1);
    }
    return matrix;
}

function setSingleWire(wire,wireNumber){
    let startingPositionX = 20000;
    let startingPositionY = 20000;
    for (let i = 0 ; i < wire.length; i++){
        let auxPositionX = startingPositionX;
        let auxPositionY = startingPositionY;
        if (wire[i].charAt(0) == 'U' || wire[i].charAt(0) == 'D'){
            startingPositionY = getNewCoordinates(wire[i], startingPositionX, startingPositionY);
        }else{
            startingPositionX = getNewCoordinates(wire[i], startingPositionX, startingPositionY);
        }
        changeChars(wireNumber, auxPositionX, startingPositionX, auxPositionY, startingPositionY);    
    }
}

function move(input, x, y){
    if(input.charAt(0) == 'U'){
        return y -= getDirection(input);
    } 
    if(input.charAt(0) == 'L'){
        return x -= getDirection(input);
    }
    if(input.charAt(0) == 'D'){
        return y += getDirection(input);
    }
    if(input.charAt(0) == 'R'){
        return x += getDirection(input);
    }
}


function getNewCoordinates(wireMovement, startingX, startingY){
    if(wireMovement.charAt(0) == 'U' || wireMovement.charAt(0) == 'D' ){
        return startingY = move(wireMovement, startingX,startingY);
    }else{
        return startingX = move(wireMovement, startingX, startingY);
    }    
}

function changeChars(newChar, startingX, newX, startingY, newY){
    if(startingX < newX){
        for(startingX; startingX < newX; startingX++){
            if(matrix[startingY][startingX] == undefined){
                matrix[startingY][startingX] = newChar;
            }else{
                if(matrix[startingY][startingX] != newChar){
                    matrix[startingY][startingX] = 'X';
                }
            }
        }
    }
    if(startingX > newX){
        for(startingX; startingX > newX; startingX--){
            if(matrix[startingY][startingX] == undefined){
                matrix[startingY][startingX] = newChar;
            }else{
                if(matrix[startingY][startingX] != newChar){
                    matrix[startingY][startingX] = 'X';
                }
            }
        }
    }
    if(startingY < newY){
        for(startingY; startingY < newY; startingY++){
            if(matrix[startingY][startingX] == undefined){
                matrix[startingY][startingX] = newChar;
            }else{
                if(matrix[startingY][startingX] != newChar){
                    matrix[startingY][startingX] = 'X';
                }
            }
        }
    }
    if(startingY > newY){
        for(startingY; startingY > newY; startingY--){
            if(matrix[startingY][startingX] == undefined){
                matrix[startingY][startingX] = newChar;
            }else{
                if(matrix[startingY][startingX] != newChar){
                    matrix[startingY][startingX] = 'X';
                }
            }
        }
    }   
    return matrix;
}

function getNearestX (iterator){
    matrix[20000][20000] = '0';
    for(let y = 20000-iterator; y < 20000+ iterator; y++){
        for(let x = 20000-iterator ; x < 20000 + iterator; x++){
            if(matrix[y][x] == 'X'){
                return Math.abs(20000-x)+Math.abs(20000-y);
            }
        }
    }  
    return getNearestX(iterator+1);
}


function runProgram(input){
    startMatrix();
    setWires(input);
    return getNearestX(0);
}