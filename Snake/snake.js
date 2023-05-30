$(document).ready(function () {
  var myCanvas = $("#myCanvas")[0];
  var context = myCanvas.getContext("2d");
  var width = $("#myCanvas").width();
  var height = $("#myCanvas").height();

  // khoi tao cac bien can su dung
  var widthUnit = 15;
  var huongDi;
  var food;
  var score;
  var ran;

  // start
  function start() {
    huongDi = "right";
    createSnake();
    createFood();
    score = 0;

    if (typeof game_loop != "undefined") clearInterval(game_loop);
    game_loop = setInterval(paintSnake, 70);
  }
  start();

  // khoi tao con ran
  function createSnake() {
    var snakeSize = 4;
    ran = [];
    for (var m = 0; m < snakeSize - 1; m++) {
      ran.push({ x: 0, y: 20 });
    }
  }

  // khoi tao moi
  function createFood() {
    food = {
      x: Math.round((Math.random() * (width - widthUnit)) / widthUnit),
      y: Math.round((Math.random() * (height - widthUnit)) / widthUnit),
    };
  }

  // ve ran
  function paintSnake() {
    context.fillStyle = "#c0f0aa";
    context.fillRect(0, 0, width, height);
    context.strokeStyle = "#0000ff";
    context.strokeRect(0, 0, width, height);

    // xac dinh toa do dau ran
    var headX = ran[0].x;
    var headY = ran[0].y;

    // thay doi toa do dau ran
    if (huongDi == "right") headX++;
    else if (huongDi == "left") headX--;
    else if (huongDi == "down") headY++;
    else if (huongDi == "up") headY--;

    // kiem tra va cham
    if (
      headX == -1 ||
      headX == width / widthUnit ||
      headY == -1 ||
      headY == height / widthUnit ||
      checkCollision(headX, headY, ran)
    ) {
      alert("Game Over");
      start();
      return;
    }

    // an moi
    if (headX == food.x && headY == food.y) {
      var snake_tail = { x: headX, y: headY };
      score++;
      createFood();
    } else {
      var snake_tail = ran.pop();
      snake_tail.x = headX;
      snake_tail.y = headY;
    }
    ran.unshift(snake_tail);

    for (var i = 0; i < ran.length; i++) {
      var k = ran[i];
      paintCell(k.x, k.y);
    }
    paintCell(food.x, food.y);

    var score_text = "Score: " + score;
    context.font = "20px Arial";
    context.fillStyle = "red";
    context.fillText(score_text, width - 100, 30);
  }

  // to mau
  function paintCell(x, y) {
    context.fillStyle = "orange";
    context.fillRect(x * widthUnit, y * widthUnit, widthUnit, widthUnit);
    context.strokeStyle = "red";
    context.strokeRect(x * widthUnit, y * widthUnit, widthUnit, widthUnit);
  }

  // kiem tra va cham
  function checkCollision(x, y, array) {
    for (var i = 0; i < array.length; i++) {
      if (array[i].x == x && array[i].y == y) return true;
    }
    return false;
  }

  // dieu khien
  $(document).keydown(function (e) {
    var keyInput = e.which;
    if (keyInput == "40" && huongDi != "up") huongDi = "down";
    else if (keyInput == "39" && huongDi != "left") huongDi = "right";
    else if (keyInput == "38" && huongDi != "down") huongDi = "up";
    else if (keyInput == "37" && huongDi != "right") huongDi = "left";
  });
});
