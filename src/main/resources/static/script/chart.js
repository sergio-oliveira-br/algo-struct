
const ctx = document.getElementById('myChart');

const myChart = new Chart (ctx, {
    type: 'bar',
    data: {
        labels: labels,
        datasets: [{
            data: data,
            label: "qty"

        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Chart.js Bar Chart'
            }
        }
    },
    scales: {
        y: {
            beginAtZero: true
        }
    },
});