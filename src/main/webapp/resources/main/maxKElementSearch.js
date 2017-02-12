$.getScript("https://www.gstatic.com/charts/loader.js", function () {


    getGraph = function (count, k) {
        
        $.get('/Algorithms/api/search/kelement', {count: count, k: k}, function (data) {
            var self = data;
            COUNT = data.length;
            var obj = [];
            for (var iter = 0; iter < data.length; iter++) {
                var masRes = [];
                masRes[0] = ["Element", "Density", {role: "style"}];
                var mas = data[iter];

                for (var i = 0; i < mas.length; i++) {
                    masRes[i + 1] = [i, mas[i], "silver"];
                }

                obj[iter] = masRes;

            }

            google.charts.load("current", {packages: ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            
            return document.getElementById("graph");
            
            
            function drawChart() {
                for (var iter = 0; iter < self.length; iter++) {
                    var data = new google.visualization.arrayToDataTable(obj[iter]);

                    var view = new google.visualization.DataView(data);
                    view.setColumns([0, 1, 2]);

                    var options = {
                        title: iter + " iteration",
                        width: 600,
                        height: 400,
                        bar: {groupWidth: "95%"},
                        legend: {position: "none"}
                    };
                    var div = document.createElement('div');
                    div.id = "columnchart_values" + iter;
                    if(iter>0){
                       div.hidden = true; 
                    }
                    document.getElementById("graph").appendChild(div);
                    var chart = new google.visualization.ColumnChart(document.getElementById(div.id));

                    chart.draw(view, options);

                }
            }
        });

    }
});
