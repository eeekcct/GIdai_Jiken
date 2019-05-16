Public Class Form1
    '============================================================================================
    '利用者がリセットボタンを押すと、Button1～Button16の表面に、0～15のランダムな数字を表示する。 
    '============================================================================================
    Private Sub Button17_Click(sender As System.Object, e As System.EventArgs) Handles Button17.Click

        'シャッフルする配列 
        Dim array As Integer() = New Integer() {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}

        'Fisher-Yatesアルゴリズムでシャッフルする 
        Dim rng As New System.Random()
        Dim n As Integer = array.Length
        While n > 1
            n -= 1
            Dim k As Integer = rng.Next(n + 1)
            Dim tmp As Integer = array(k)
            array(k) = array(n)
            array(n) = tmp
        End While

        Button1.Text = array(0)
        Button2.Text = array(1)
        Button3.Text = array(2)
        Button4.Text = array(3)
        Button5.Text = array(4)
        Button6.Text = array(5)
        Button7.Text = array(6)
        Button8.Text = array(7)
        Button9.Text = array(8)
        Button10.Text = array(9)
        Button11.Text = array(10)
        Button12.Text = array(11)
        Button13.Text = array(12)
        Button14.Text = array(13)
        Button15.Text = array(14)
        Button16.Text = array(15)
    End Sub

End Class
