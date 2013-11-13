using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Diagnostics;

namespace WindowsFormsApplication1
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Main());
        }
        public static string openFile() { 
            var ofd = new OpenFileDialog();
            ofd.Filter = "H# Files (*.hsf)|*.hsf";
            ofd.ShowDialog();
            return ofd.FileName;
        }
        public static void getHTML(string inFile, string outFile)
        {

            if (outFile.Equals("") | inFile.Equals(""))
            {
                MessageBox.Show("Choose Files First");
            }
            else
            {
                while (File.Exists(inFile) != true)
                {
                }
                var appLoc = AppDomain.CurrentDomain.BaseDirectory;
                saveBatFile("i.jar", appLoc, inFile, appLoc + "r.bat");
                var process = Process.Start(appLoc + "r.bat");
                process.WaitForExit(3000);
                var ofile = inFile.Replace(".hsf", ".html");
                var mfile = outFile;
                if (ofile != mfile)
                {
                    if (File.Exists(mfile))
                        File.Delete(mfile);

                    // Move the file.
                    File.Move(ofile, mfile);
                }
            }
        }

        public static void saveBatFile(string file, string location, string argument, string batLoc)
        {
            string[] lines = { "cd " + location, "java -jar " + file + " " + argument };
            System.IO.File.WriteAllLines(batLoc, lines);
        }
    }
}

