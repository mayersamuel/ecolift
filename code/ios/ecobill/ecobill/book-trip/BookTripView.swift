import SwiftUI

struct BookTripView: View {
    var body: some View {
        VStack {
            Text("Book Trip")
                .font(.title)
                .padding(.top, 5)
            Spacer()
            
        }
    }
}

#Preview {
    ContentView(selectedTab: 0)
}
