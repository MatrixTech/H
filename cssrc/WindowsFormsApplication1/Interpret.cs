using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApplication1
{
    public partial class Interpret : Form
    {
        public Interpret()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void fileChooseLoc_Click(object sender, EventArgs e)
        {
            getFileLoc.ShowDialog();
            inputLoc.Text = getFileLoc.FileName;
        }

        private void getFIleLoc_FileOk(object sender, CancelEventArgs e)
        {

        }

        private void fileChooseOutLoc_Click(object sender, EventArgs e)
        {
            getOutLoc.ShowDialog();
            outputLoc.Text = getOutLoc.FileName;
        }

        private void fileAction_Click(object sender, EventArgs e)
        {
            Program.getHTML(inputLoc.Text, outputLoc.Text);
        }
    }
}
