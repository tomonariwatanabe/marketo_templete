var gulp = require('gulp');
var cheerio = require('cheerio');
var map = require('map-stream');
var minimist = require('minimist');
var browserSync = require('browser-sync');

const options = minimist(process.argv.slice(2), {
  string: 'env',
  default: {
    env: 'development'
  }
});

const option_text = options.env;


gulp.task('default', function (done) {
  if (option_text == 'develop') {
    gulp.src('./*_templete/**/*.html')
      .pipe(map(function (file, done) {
        var html = file.contents.toString();
        var $$ = cheerio.load(html);
        $$('meta').each(function () {
          var meta = $$(this);
          var variable = new RegExp('\\$\\{' + meta.attr('id') + '\\}', 'g');
          var value = "";
          if (meta.attr('units')) {
            value = meta.attr('default') + meta.attr('units')
          } else {
            value = meta.attr('default')
          };
          html = html.replace(variable, value);
        });
        file.contents = Buffer.from(html);
        done(null, file);
      }))
      .pipe(gulp.dest('dev'));
    done();
  } else if (option_text == 'prod') {
    gulp.src('./*_templete/**/*.html')
      .pipe(map(function (file, done) {
        var html = file.contents.toString();
        var $$ = cheerio.load(html);
        $$('meta').each(function () {
          var meta = $$(this);
          var variable = new RegExp('\\$\\{' + meta.attr('id') + '\\}', 'g');
          var value = "";
          if (meta.attr('units')) {
            value = meta.attr('default') + meta.attr('units')
          } else {
            value = meta.attr('default')
          };
          html = html.replace(variable, value);
        });
        file.contents = Buffer.from(html);
        done(null, file);
      }))
      .pipe(gulp.dest('prod'));
    done();
  }
});