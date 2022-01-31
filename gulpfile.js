var gulp = require('gulp');
var cheerio = require('cheerio');
var map = require('map-stream');

gulp.task('default', function (done) {
    gulp.src('./static_templete/templete.html')
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
        .pipe(gulp.dest('build'));
    done();
});