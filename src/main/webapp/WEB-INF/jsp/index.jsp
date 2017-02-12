<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Зажжем!!!</title>
    </head>
    <body>
        <script src="./resources/js/react-15.3.1/build/react.js"></script>
        <script src="./resources/js/react-15.3.1/build/react-dom.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.24/browser.min.js"></script>
        <script src="./resources/js/jquery-3.1.1.min.js"></script>
        <script src="./resources/main/maxKElementSearch.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            var COUNT;
            setTimeout(slideShow, 2000);
            
            function slideShow() {
                for(var i=0; i<COUNT; i++){
                    var chart = document.getElementById("columnchart_values" + i);
                    if(!chart.hidden){
                        chart.hidden = true;
                        if(i+1<COUNT){
                            document.getElementById("columnchart_values" + (i+1)).hidden = false;
                        }else{
                            document.getElementById("columnchart_values0").hidden = false;
                        }
                        break;
                    }
                }
                setTimeout(slideShow, 2000);
            }
        </script>
        <script type="text/babel">
            var Counter = React.createClass({
                getInitialState: function () {
                    return { count: 10000,
                                 k: 12};
                },
                handleClick: function () {
                    getGraph(this.state.count, this.state.k)   
                },
            render: function () {
                return (
                    <button onClick={this.handleClick}>
                        Search k element
                    </button>
                );
            }
            });
      ReactDOM.render(
        <Counter />,
        document.getElementById('container')
      );
    </script>
    <div id="container">
            
    </div>
    <div id="graph">
    </div>
        
    </body>
</html>
