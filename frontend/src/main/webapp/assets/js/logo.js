$(function() {
	
/*some colors on a JSON table (very usefull to store some data)*/
var color = [{
        "1": [
            '#441650',
            '#672178',
            '#892ca0',
            '#ab37c8',
            '#bc5fd3',
            '#cd87de'
        ],
        "2": [
            '#aa4400',
            '#d45500',
            '#ff6600',
            '#ff7f2a',
            '#ff9955',
            '#ffb380'
        ],
        "3": [
            '#ff550a',
            '#ff550a',
            '#ff9e0a',
            '#ffb051',
            '#ffc051',
            '#ffdd81'
        ],
         "4" : [
        		'#2d5016', 
        		'#447821', 
       		  '#5aa02c', 
       		  '#71c837', 
       		  '#8dd35f', 
      	    '#aade87'
         ],
         "5" : [
       			'#373e48',
      			'#535d6c',
       			'#6f7c91',
       			'#939dac',
       			'#b7bec8',
       			'#dbdee3'
         ],
         "6" :[
        	  '#800033',
            '#aa0044',
            '#d40055',
            '#ff0066',
            '#ff2a7f',
            '#ff5599'
         ],
         "7" : [
      			'#aa8800', 
            '#d4aa00', 
            '#ffcc00', 
            '#ffd42a', 
            '#ffdd55', 
            '#ffe680'
         ],
         "8" : [
       		 '#004455',
           '#006680',
           '#0088AA',
           '#00AAD4',
           '#00CCFF',
           '#80E5FF'
         ],
         "9" : [
         '#2B0069',
         '#40009D',
         '#5600D1',
         '#7833DA',
         '#9A66E3',
         '#BB99ED'
         ],
         "10" : [
         '#005544',
         '#008066',
         '#00AA88',
         '#00D4AA',
         '#00FFCC',
         '#80FFE6'
         ],
         "11" : [
        '#FA4242',
        '#FB5B5B',
        '#FC7979',
        '#FDA1A1',
        '#FEC4C4',
        '#FED4D4'
         ],
         "12" : [
       '#800033',
       '#AA0000',
       '#D40000',
       '#FF0000',
       '#FF5555',
       '#FF8080'
         ],
         "13" : [
        '#4E003A',
        '#91006D',
        '#C70096',
        '#F700BB',
        '#FF5DD8',
        '#FFAEEB'
         ],
         "14" : [
        '#6C8700',
        '#8BAE00',
        '#ADD800',
        '#C2F300',
        '#D9FF42',
        '#E1FF74'
         ],
         "15" : [
         '#00D400',
         '#00FF00',
         '#55FF55',
         '#80FF80',
         '#AAFFAA',
         '#D5FFD5'
         ],
         "16" : [
         '#0080AA',
         '#00A9E0',
         '#1DBCFF',
         '#70D5FF',
         '#85EAFF',
         '#AEF9FF'
         ],
         "17" : [
         '#00235E',
         '#00348D',
         '#0046BC',
         '#336BC9',
         '#6690D7',
         '#99B5E4'
         ]
    }];
//one random color to start
i = Math.floor(Math.random() * 17) + 1;

//we gave the right timing to our variable
delay = 2000;
changetime = 100;
//the main function, to make the color change
// (we call it one time to begin it)
loadlogo();

//here is the main
function loadlogo() {
    ibc = i;
  //we take one random color
 i = Math.floor(Math.random() * 17) + 1;
  //a little security test to not pick two time the same color
    if (i == ibc) {
 i = Math.floor(Math.random() * 17) + 1;
    }
  //the principal timeout who will be recall each "delay"
  setTimeout(function() {
    //each timeout here will change one color on each path of the SVG logo
     setTimeout(function() {$('#path1').css({fill: color[0][i][5]}); },changetime);
     setTimeout(function() {$('#path2').css({fill: color[0][i][4]}); },changetime*2);
     setTimeout(function() {$('#path3').css({fill: color[0][i][3]}); },changetime*3);
     setTimeout(function() {$('#path4').css({fill: color[0][i][2]}); },changetime*4);
     setTimeout(function() {$('#path5').css({fill: color[0][i][1]}); },changetime*5);
     setTimeout(function() {$('#path6').css({fill: color[0][i][0]}); },changetime*6);
     setTimeout(function() {$('#text-TSI').css({fill: color[0][i][1]}); },changetime*7);
    //it will auto call the function again after each "delay"
      loadlogo();
}, delay); 
}


});