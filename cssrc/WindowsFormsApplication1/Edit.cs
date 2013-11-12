using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace WindowsFormsApplication1
{
    public partial class Edit : Form
    {
        public Edit()
        {
            InitializeComponent();
        }
        public Edit(string file)
        {
            InitializeComponent();
        }

        private void Edit_Load(object sender, EventArgs e)
        {
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            saveHTML.ShowDialog();
            var appLoc = Environment.GetFolderPath(Environment.SpecialFolder.ApplicationData) + @"\h\";
            if (Directory.Exists(appLoc)) { 
            } else {
            Directory.CreateDirectory(appLoc);
            }
            System.IO.File.WriteAllLines(appLoc + "temp.hsf", editText.Lines);
            Program.getHTML(appLoc + "temp.hsf", saveHTML.FileName);
        }

        private void asHFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveH.ShowDialog();
            System.IO.File.WriteAllLines(saveH.FileName, editText.Lines);
        }

        private void editText_TextChanged(object sender, EventArgs e)
        {
        }
        private void editText_KeyPress(object sender, KeyPressEventArgs e)
        {
        }

    }
}
