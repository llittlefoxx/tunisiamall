circleDiagram = function (diagramId, w, h, diagramData) {
  'use strict';
  var o = {
    init: function(){
      this.diagram();
    },
    random: function(l, u){
      return Math.floor((Math.random()*(u-l+1))+l);
    },
    diagram: function(){
      var r = new Raphael(diagramId, w, h),
          rad = 73,
          rw = w/2,
          rh = h/2,
          circlerad = h/6.5,    // radius of central circle
          strokew = h/25,     // width of arc stroke
          strokehvr = h/12.5; // stroke on hover

      r.circle(rw, rh, circlerad).attr({ stroke: 'none', fill: '#193340' });

      var title = r.text(rw, rh, 'Skills').attr({
          font: '20px Arial',
          fill: '#fff'
      }).toFront();

      r.customAttributes.arc = function(value, color, rad){
        var v = 3.6*value,
            alpha = v === 360 ? 359.99 : v,
            random = o.random(91, 240),
            a = (random-alpha) * Math.PI/180,
            b = random * Math.PI/180,
            sx = rw + rad * Math.cos(b),
            sy = rh - rad * Math.sin(b),
            x = rw + rad * Math.cos(a),
            y = rh - rad * Math.sin(a),
            path = [['M', sx, sy], ['A', rad, rad, 0, +(alpha > 180), 1, x, y]];
        return { path: path, stroke: color };
      };

      $(diagramData).find('.arc').each(function() {
        var t = $(this),
            color = t.find('.color').val(),
            value = t.find('.percent').val(),
            text = t.find('.text').text();
        rad += 20;
        var z = r.path().attr({ arc: [value, color, rad], 'stroke-width': strokew });
        z.mouseover(function(){
          this.animate({ 'stroke-width': strokehvr, opacity: 0.75 }, 1000, 'elastic');
          if(Raphael.type !== 'VML') {//solves IE problem
            this.toFront();
          }
          title.animate({ opacity: 0 }, 500, '>', function() {
              this.attr({ text: text + '\n' + value + '%' }).animate({ opacity: 1 }, 500, '<');
          });
        }).mouseout(function(){
          this.animate({ 'stroke-width': strokew, opacity: 1 }, 1000, 'elastic');
        });
      });
    }
  };
  return o.init();
};