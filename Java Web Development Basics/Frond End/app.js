$('#btn-add')
.on('click', () => {
    $('#list'
    .append($('<li>New </li>')))
});

const getRandom = (maxValue) => parseInt(Math.random() * (maxValue));

const getRandomColor = () => {
    return `rbg(${getRandom(256)}, ${getRandom(256)}, ${getRandom(256)})`;
}


$('#list').on('click', 'li', function() {

    if($(this).hasClass('selected')) {
        $(this).removeClass('selected')
    } else {
        $(this).addClass('selected');
 //       $(this).css('backgrouun', getRandomColor())
    }

})

$('<div/>')
    .text('I am a new div')
    .css('background', 'blue')
    .css('color', 'white')
    .appendTo(document.body);


    $('h1')
    .on('mouseover', function () {
        $(this).addClass('selected')
    })


    // Mouse events
    // Form events
    // Keyboard events