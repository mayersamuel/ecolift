import SwiftUI

struct ContentView: View {
    @State var selectedTab = 0
    var body: some View {
        TabView(selection: $selectedTab) {
            BookTripView()
                .tabItem {
                    Image(systemName: "figure.wave")
                    Text("Book Trip")
                }
                .tag(0)
            CreteTripView()
                .tabItem {
                    Image(systemName: "plus.circle")
                    Text("Create Trip")
                }
                .tag(1)
            SettingsView()
                .tabItem {
                    Image(systemName: "gear")
                    Text("Settings")
                }
                .tag(2)
        }
        .padding(.top, 10)
    }
}

#Preview {
    ContentView(selectedTab: 0)
}
