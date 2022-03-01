var gulp = require('gulp');
var cheerio = require('cheerio');
var map = require('map-stream');
var minimist = require('minimist');
var replace = require('gulp-token-replace');

const options = minimist(process.argv.slice(2), {
  string: 'env',
  default: {
    env: 'dev'
  }
});

const option_text = options.env;
gulp.task('default', function (done) {
  if (option_text == 'local_dev') {
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
      .pipe(gulp.dest('local'));
    done();
  } else if (option_text == 'dev') {
    var config = require('./dev-replace_config.json');
    gulp.src(['./*_templete/**/*.java', './*_templete/**/templete.html', './*_templete/snippet/*.html'])
      .pipe(replace({
        global: config,
        prefix: '{%',
        suffix: '%}',
      }))
      .pipe(gulp.dest('dev'));
    done();
  } else if (option_text == 'prod') {
    var config = require('./prod-replace_config.json');
    gulp.src(['./*_templete/**/*.java', './*_templete/**/templete.html', './*_templete/snippet/*.html'])
      .pipe(replace({
        global: config,
        prefix: '{%',
        suffix: '%}',
      }))
      .pipe(gulp.dest('prod'));
    done();
  }
});