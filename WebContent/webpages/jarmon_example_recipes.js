/* Copyright (c) Richard Wall
 * See LICENSE for details.
 *
 * Some example recipes for Collectd RRD data - you *will* need to modify this
 * based on the RRD data available on your system.
 */

if(typeof(jarmon) === 'undefined') {
    var jarmon = {};
}
var servername='localhost';
var vmname='test';

jarmon.TAB_RECIPES_STANDARD = [
 		[ vmname,     [vmname+'cpu'] ],//��recipes�����key��Ӧ
    [ servername,  ['cpu', 'memory','load','interface'] ]
];

var vcpu0data=[vmname+'/libvirt/virt_vcpu-0.rrd', 0, 'CPU-0', ''];
var vcpu1data=[vmname+'/libvirt/virt_vcpu-1.rrd', 0, 'CPU-1', ''];
var vcputotaldata=[vmname+'/libvirt/virt_cpu_total.rrd', 0, 'CPU-TOTAL', ''];
var vmdata=[vcpu0data,vcputotaldata];


jarmon.CHART_RECIPES_COLLECTD = {
		'vmcpu' : {
        title: 'vm_cpu',
        data:  vmdata,//data����ļ�ӳ���ϵ��̬���
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS,jarmon.Chart.STACKED_OPTIONS)
    },
    
    'vmnet' : {
        title: 'vm_net',
        data: [
            [vmname+'/libvirt/if_octets-vnet0.rrd', 'tx', 'veth0 Transmit', 'B'],
            [vmname+'/libvirt/if_octets-vnet0.rrd', 'rx', 'veth0 Receive', 'B'],
           // [vmname+'/libvirt/if_octets-vnet1.rrd', 'tx', 'veth1 Transmit', 'B'],
           // [vmname+'/libvirt/if_octets-vnet1.rrd', 'rx', 'veth1 Receive', 'B']
        ],
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS,
                                         jarmon.Chart.STACKED_OPTIONS)
    },
          
    'cpu': {
        title: 'CPU Usage',
        data: [
            [servername+'/cpu-0/cpu-wait.rrd', 0, 'CPU-0 Wait', '%'],
            [servername+'/cpu-1/cpu-wait.rrd', 0, 'CPU-1 Wait', '%'],
            [servername+'/cpu-0/cpu-system.rrd', 0, 'CPU-0 System', '%'],
            [servername+'/cpu-1/cpu-system.rrd', 0, 'CPU-1 System', '%'],
            [servername+'/cpu-0/cpu-user.rrd', 0, 'CPU-0 User', '%'],
            [servername+'/cpu-1/cpu-user.rrd', 0, 'CPU-1 User', '%']
        ],
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS,
                                         jarmon.Chart.STACKED_OPTIONS)
    },
    
    'memory': {
        title: 'Memory',
        data: [
            [servername+'/memory/memory-buffered.rrd', 0, 'Buffered', 'B'],
            [servername+'/memory/memory-used.rrd', 0, 'Used', 'B'],
            [servername+'/memory/memory-cached.rrd', 0, 'Cached', 'B'],
            [servername+'/memory/memory-free.rrd', 0, 'Free', 'B']
        ],
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS,
                                         jarmon.Chart.STACKED_OPTIONS)
    },

    'load': {
        title: 'Load Average',
        data: [
            [servername+'/load/load.rrd', 'shortterm', 'Short Term', ''],
            [servername+'/load/load.rrd', 'midterm', 'Medium Term', ''],
            [servername+'/load/load.rrd', 'longterm', 'Long Term', '']
        ],
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS)
    },

    'interface': {
        title: 'Interface Throughput',
        data: [
               //根据物理服务器的物理网卡数量进行添加
            [servername+'/interface/if_octets-eth0.rrd', 'tx', 'eth0 Transmit', 'bit/s', function (v) { return v*8; }],
            [servername+'/interface/if_octets-eth0.rrd', 'rx', 'eth0 Receive', 'bit/s', function (v) { return v*8; }],
            [servername+'/interface/if_octets-eth1.rrd', 'tx', 'eth1 Transmit', 'bit/s', function (v) { return v*8; }],
            [servername+'/interface/if_octets-eth1.rrd', 'rx', 'eth1 Receive', 'bit/s', function (v) { return v*8; }],
//            [servername+'/interface/if_octets-virbr0.rrd', 'tx', 'virbr0 Transmit', 'bit/s', function (v) { return v*8; }],
//            [servername+'/interface/if_octets-virbr0.rrd', 'rx', 'virbr0 Receive', 'bit/s', function (v) { return v*8; }],
//            [servername+'/interface/if_octets-vnet0.rrd', 'tx', 'vnet0 Transmit', 'bit/s', function (v) { return v*8; }],
//            [servername+'/interface/if_octets-vnet0.rrd', 'rx', 'vnet0 Receive', 'bit/s', function (v) { return v*8; }]
        ],
        options: jQuery.extend(true, {}, jarmon.Chart.BASE_OPTIONS)
    }
    
};
