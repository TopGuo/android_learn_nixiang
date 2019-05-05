using System;

using Android.App;
using Android.Content;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;

namespace sharpapp
{
	[Activity (Label = "sharpapp", MainLauncher = true)]
	public class Activity1 : Activity
	{
		//int count = 1;

		protected override void OnCreate (Bundle bundle)
		{
			base.OnCreate (bundle);

			// Set our view from the "main" layout resource
			SetContentView (Resource.Layout.Main);
			this.Title = "Mono for Android演示程序";

			// Get our button from the layout resource,
			// and attach an event to it
			Button button = FindViewById<Button> (Resource.Id.myButton);
			
			button.Click += delegate {
				//button.Text = string.Format ("{0} clicks!", count++);
				if (this.PackageName.Equals("com.droider.sharpapp")) {
					Toast.MakeText(this, "unregister version!", ToastLength.Short).Show();
				} else {
					Toast.MakeText(this, "thank you for your registration!", ToastLength.Short).Show();
				}
			};
		}
	}
}


