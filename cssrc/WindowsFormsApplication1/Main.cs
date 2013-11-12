using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            var newInter = new Interpret();
            newInter.Show();
        }

        private void menuNew_Click(object sender, EventArgs e)
        {
            var newEdit = new Edit();
            newEdit.Show();
        }

        private void Main_Load(object sender, EventArgs e)
        {

        }
    }
}
