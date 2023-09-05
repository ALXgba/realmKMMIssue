import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
    @ObservedObject var dummy = DummyViewRefresher()
    var leaker = RealmLeaker()

	var body: some View {
        NavigationView {
            Text(greet)
        }
        .onAppear() {
            var timer1 = Timer.scheduledTimer(withTimeInterval: 0.1, repeats: true) { timerI in
                // Leaking
                leaker.leak()
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

class DummyViewRefresher : ObservableObject {
    var check = true
    func refreshView() {
        self.objectWillChange.send()
    }
}
